/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panelContol;

import database.SelectIdControlfromVerificacionList;
import database.Conexion;
import helper.GetIdandExtensionImg;
import files.GetFinalListOfImages;
import documents.GetFinalListOfDocuments;
import helper.GetParent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class AceptarCargarLote {

    private JComboBox tipoDocumentoBox;
    private JComboBox tipoVerificacionBox;
    private JTextField pathnameJtext;
    private Conexion conexion;
    private JButton aceptarButton;
    private JLabel infoJLabel;
    private static int idUsuario;
    private JFrame cargarLoteFrame;
    private List<Integer> idtipoControlList = new ArrayList<>();
    private TryFilechooser chooser;

    public AceptarCargarLote(JFrame frame, JTextField pathJtext,
            JButton aceptarJButton, JComboBox tipoDocumentoBox,
            JComboBox tipoVerificacionBox, JLabel infoLabel,
            Conexion conexion, int idUsuario, TryFilechooser chooser) {
        this.tipoDocumentoBox = tipoDocumentoBox;
        this.tipoVerificacionBox = tipoVerificacionBox;
        this.pathnameJtext = pathJtext;
        this.conexion = conexion;
        this.aceptarButton = aceptarJButton;
        this.infoJLabel = infoLabel;
        this.cargarLoteFrame = frame;
        this.chooser = chooser;
        getAceptar();
    }

    private void getAceptar() {
        int valor = 0;
        String ruta = pathnameJtext.getText();//trae la ruta
        File file = new File(ruta);//busca el file
        if (file.exists()) {
            if (tipoVerificacionBox.getSelectedItem().toString().equalsIgnoreCase("2-Control Básico de Documento")) {
                valor = (TryFilechooser.isaDirectory()) ? 4 : 3;
            } else {
                valor = (TryFilechooser.isaDirectory()) ? 2 : 1;
            }
            xxx(valor, file);
        } else {
            JOptionPane.showMessageDialog(pathnameJtext,
                    "Ruta incorrecta", "Error en el ingreso de la ruta", JOptionPane.ERROR_MESSAGE);
            pathnameJtext.setText("");
        }
    }

    private void xxx(int valor, File file) {
        switch (valor) {
            //verificacion de control de calidad
            case 1:
            case 2:
                getFilesForVols(valor, file);
                break;
            //verificacion de control de documento
            case 3:
            case 4:
                getDocs(valor, file);
                break;
        }
        aceptarButton.setEnabled(false);

    }

    private void getFilesForVols(int valor, File file) {
        GetFinalListOfImages idext = null;
        getControlesPorVerificacion();
        conexion.isConexionClose();
        switch (valor) {
            case 1:
                File[] files = file.listFiles();
                GetParent parent = new GetParent(files); // trae la ruta completa
                idext = new GetFinalListOfImages(cargarLoteFrame,
                        infoJLabel, idtipoControlList, file, getTipoDocumento(),
                        SelectIdControlfromVerificacionList.getIdVerificacion(), null);
                idext.execute();
                break;
            case 2:
                idext = new GetFinalListOfImages(cargarLoteFrame,
                        infoJLabel, idtipoControlList, null, getTipoDocumento(),
                        SelectIdControlfromVerificacionList.getIdVerificacion(), chooser);
                idext.execute();
                break;
        }
    }

    private void getDocs(int valor, File file) {
        getControlesPorVerificacion();
        conexion.isConexion();
        ContadorSublotes contadorSublotes = null;
        switch (valor) {
            case 3:
                contadorSublotes = new ContadorSublotes(file);
                break;
            case 4:
                contadorSublotes = new ContadorSublotes(chooser);
                break;
        }
        GetIdandExtensionImg extensionIdImagen = new GetIdandExtensionImg(ContadorSublotes.getExtension());
        List<Object> listaIdc = contadorSublotes.getDocumentoList();
        GetFinalListOfDocuments idext = new GetFinalListOfDocuments(cargarLoteFrame,
                infoJLabel, getTipoDocumento(),
                SelectIdControlfromVerificacionList.getIdVerificacion(),
                idtipoControlList, listaIdc);
        idext.execute();
    }

    public List<Integer> getIdTipoControlList() {
        return idtipoControlList;
    }

    private int getTipoDocumento() {
        String result = (String) tipoDocumentoBox.getSelectedItem();
        String[] dos = result.split("-");
        int id = Integer.parseInt(dos[0]);
        return id;
    }

    private void getControlesPorVerificacion() {
        SelectIdControlfromVerificacionList ctrls = new SelectIdControlfromVerificacionList();
        idtipoControlList = ctrls.idControlesByVerificacion(tipoVerificacionBox, conexion, idtipoControlList);
    }
}
