package br.com.etec.aula20240906;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private Button btnCadastrar;

    @FXML
    private CheckBox chkCasado;

    @FXML
    private ToggleGroup grpSexo;

    @FXML
    private RadioButton rbFeminino;

    @FXML
    private RadioButton rbMasculino;

    @FXML
    private TextArea txtAreaDados;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTelefone;

    private Cliente cliente;
    private List<Cliente> listaClientes = new ArrayList<>();

    @FXML
    protected void onClickCadastrar() {
        if(txtNome.getText().equals("")) {
            avisaCampoBranco("Nome em Branco");
            return;
        }

        if(txtEmail.getText().equals("")) {
            avisaCampoBranco("Email em Branco");
            return;
        }

        if(txtTelefone.getText().equals("")) {
            avisaCampoBranco("Telefone em Branco");
            return;
        }


        if(!rbFeminino.isSelected() && !rbMasculino.isSelected()) {
            avisaCampoBranco("Caixa de sexo não selecionada");
            return;
        }

        String sexo = rbMasculino.isSelected()? "Masculino" : "Feminino";
        int id = listaClientes.size() + 1;
        cliente = new Cliente(id, txtNome.getText(), txtEmail.getText(), txtTelefone.getText(), sexo,chkCasado.isSelected());

        listaClientes.add(cliente);
        txtAreaDados.setText(listaClientes.toString());

        limparCampos();

    }

    private void limparCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
        rbMasculino.setSelected(false);
        rbFeminino.setSelected(false);
        chkCasado.setSelected(false);
        txtNome.requestFocus();
    }

    private void avisaCampoBranco(String campo) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Aviso");
        alerta.setHeaderText("Campo em Branco");
        alerta.setContentText(campo);
        alerta.show();
        return;
    }
}