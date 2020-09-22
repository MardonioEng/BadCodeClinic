package br.com.ifce.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.com.ifce.aplicacao.Main;
import br.com.ifce.aplicacao.TelaCadastro;
import br.com.ifce.aplicacao.TelaRTecnico;
import br.com.ifce.aplicacao.TelaSupervisor;
import br.com.ifce.dao.UsuarioDAO;
import br.com.ifce.model.Usuario;
import br.com.ifce.model.enums.TipoUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginViewControler implements Initializable {

	@FXML
	private JFXTextField txtLogin;
	@FXML
	private JFXPasswordField txtSenha;
	@FXML
	private JFXButton btnLogin;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML
	void login(ActionEvent event) {
		System.out.println("Oi");

		try {
			Main.getStage().close();
			
			String login = txtLogin.getText();
			String senha = txtSenha.getText();
			
			List<Usuario> usuarios = UsuarioDAO.getInstance().findAll();
			
			boolean usuarioEncontrado = false;
			for (Usuario u : usuarios) {
				if(u.getLogin().equals(login) && u.getSenha().equals(senha)) { 
					if(u.getTipoUsuario() == TipoUsuario.CADASTRO) {
						TelaCadastro telaTeste = new TelaCadastro();
						telaTeste.start(new Stage());
					} else if(u.getTipoUsuario() == TipoUsuario.RESPONSAVEL_TECNICO) {
						TelaRTecnico telaRTecnico = new TelaRTecnico();
						telaRTecnico.start(new Stage());
					} else if(u.getTipoUsuario() == TipoUsuario.SUPERVISOR) {
						TelaSupervisor telaSupervisor = new TelaSupervisor();
						telaSupervisor.start(new Stage());
					}
					usuarioEncontrado = true;
					break;
				}
			}
			if(usuarioEncontrado == true) { 
				Main.getStage().close();
			}
			else {
				new Main().start(new Stage());
				Alert alert = new Alert(AlertType.ERROR);
				alert.show();
			}
				//System.out.println("Usuario não encontrado!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
