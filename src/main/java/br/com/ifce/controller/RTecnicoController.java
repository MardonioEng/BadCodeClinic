package br.com.ifce.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.com.ifce.aplicacao.TelaRTecnicoResultado;
import br.com.ifce.dao.ColetaDAO;
import br.com.ifce.dao.ExameDAO;
import br.com.ifce.model.Coleta;
import br.com.ifce.model.Exame;
import br.com.ifce.model.enums.TipoColeta;
import br.com.ifce.model.util.PacienteTabela;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RTecnicoController implements Initializable {

	@FXML private JFXButton btnSair;
	@FXML private JFXButton btnEmitirResultado;
	@FXML private TableView<PacienteTabela> tblPacientes;
	@FXML private TableColumn<PacienteTabela, Long> colId;
	@FXML private TableColumn<PacienteTabela, String> colNome;
	@FXML private TableColumn<PacienteTabela, Long> colCpf;
	@FXML private TableColumn<PacienteTabela, LocalDate> colDataNascimento;
	@FXML private TableColumn<PacienteTabela, TipoColeta> colTipoColeta;
	
	public static Long idPacienteSelecionado;

	List<PacienteTabela> pacientesTabelaList = new ArrayList<PacienteTabela>();
	ObservableList<PacienteTabela> pacientesTabela;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarListaDePacientes();
		filtrarPacientes(); //Filtrar pacientes que ainda não fizeram o exame. Já preenche a Lista do tipo ObservableList
		preecheTableView();
	}
	
	private void carregarListaDePacientes() {
		List<Coleta> coletas = ColetaDAO.getInstance().findAll();
		coletas.stream().forEach(coleta -> 
			pacientesTabelaList.add(new PacienteTabela(coleta.getPaciente().getId(), 
													   coleta.getPaciente().getNome(), 
													   coleta.getPaciente().getCpf(),
													   coleta.getPaciente().getDataNascimento(),
													   coleta.getTipoColeta()))
														);
	}
	
	private void filtrarPacientes() {
		List<Exame> exames = ExameDAO.getInstance().findAll();
		if(!exames.isEmpty()) {
			for (Exame exame : exames) {
				Long id = exame.getPaciente().getId();
				for (PacienteTabela paciente : pacientesTabelaList) {
					if(id.equals(paciente.getId())) {
						pacientesTabelaList.remove(paciente);
					}
				}
			}
		}
		pacientesTabela = FXCollections.observableArrayList(pacientesTabelaList);
	}
	
	private void preecheTableView() {
		
		colId.setCellValueFactory(new PropertyValueFactory<PacienteTabela, Long>("id"));
		colNome.setCellValueFactory(new PropertyValueFactory<PacienteTabela, String>("nome"));
		colCpf.setCellValueFactory(new PropertyValueFactory<PacienteTabela, Long>("cpf"));
		colDataNascimento.setCellValueFactory(new PropertyValueFactory<PacienteTabela, LocalDate>("dataNascimento"));
		colTipoColeta.setCellValueFactory(new PropertyValueFactory<PacienteTabela, TipoColeta>("tipoColeta"));
		
		tblPacientes.setItems(pacientesTabela);
		
	}
	
	@FXML
	void onBtnEmitirResultadoAction(ActionEvent event) throws Exception {
		
		Long idSelecionado = tblPacientes.getSelectionModel().getSelectedItem().getId();
		System.out.println(idSelecionado);

		TelaRTecnicoResultado telaRTecnicoResultado = new TelaRTecnicoResultado();
		telaRTecnicoResultado.start(new Stage());

	}
	
	@FXML
	void onBtnSairAction(ActionEvent event) {
		
	}
	
}
