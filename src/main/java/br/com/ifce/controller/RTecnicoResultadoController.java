package br.com.ifce.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RTecnicoResultadoController implements Initializable {

	@FXML
	private TextField tfNome;
	@FXML
	private TextField tfCpf;
	@FXML
	private TextField tfDataNascimento;
	@FXML
	private TextField tfRg;
	@FXML
	private ComboBox<?> cbSexo;
	@FXML
	private TextField tfComorbidade;
	@FXML
	private ComboBox<?> cbConclusao;
	@FXML
	private TextField tfDataExame;
	@FXML
	private JFXButton btnSair;
	@FXML
	private JFXButton btnSalvar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML
	void onBtnSairAction(ActionEvent event) {

	}

	@FXML
	void onBtnSalvarAction(ActionEvent event) {

	}

}
