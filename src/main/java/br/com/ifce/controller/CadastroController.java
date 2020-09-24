package br.com.ifce.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.com.ifce.dao.ColetaDAO;
import br.com.ifce.dao.PacienteDAO;
import br.com.ifce.model.Coleta;
import br.com.ifce.model.Paciente;
import br.com.ifce.model.enums.TipoColeta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CadastroController implements Initializable {

	@FXML private JFXButton btnSair;
	@FXML private JFXButton btnSalvar;
	@FXML private TextField tfNome;
    @FXML private TextField tfComorbidade;
	@FXML private TextField tfCpf;
	@FXML private TextField tfDataNascimento;
	@FXML private TextField tfRg;
	@FXML private TextField tfCep;
	@FXML private TextField tfRua;
	@FXML private TextField tfBairro;
	@FXML private TextField tfEstado;
	@FXML private TextField tfCidade;
	@FXML private TextField tfNumero;
	@FXML private TextField tfComplemento;
	@FXML private TextField tfColetor;
	@FXML private ComboBox<String> cbSexo;
	@FXML private ComboBox<TipoColeta> cbTipoMaterialColetado;

	ObservableList<String> opcoesSexo;
	List<TipoColeta> tipoMaterialColetado = new ArrayList<TipoColeta>();
	ObservableList<TipoColeta> opcoesMaterialColetado;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarComboboxSexo();
		carregaComboboxTipoMaterial();
	}

	private void carregarComboboxSexo() {
		opcoesSexo = FXCollections.observableArrayList(Arrays.asList("Feminino", "Masculino"));
		cbSexo.setItems(opcoesSexo);
	}

	private void carregaComboboxTipoMaterial() {
		tipoMaterialColetado.add(TipoColeta.ASPIRADO_BRONQUICO);
		tipoMaterialColetado.add(TipoColeta.ASPIRADO_NASO_FARINGIEO);
		tipoMaterialColetado.add(TipoColeta.ASPIRADO_TRAQUEAL);
		tipoMaterialColetado.add(TipoColeta.ESCARRO);
		tipoMaterialColetado.add(TipoColeta.LAVADO_BRONCOALVEOLAR);
		tipoMaterialColetado.add(TipoColeta.SECRECAO_TRAQUEAL);

		opcoesMaterialColetado = FXCollections.observableArrayList(tipoMaterialColetado);
		cbTipoMaterialColetado.setItems(opcoesMaterialColetado);
	}

	@FXML
	void onBtnSairAction(ActionEvent event) {
		System.out.println("botao sair");
	}

	@FXML
	void onBtnSalvarAction(ActionEvent event) {
		
		LocalDate dataNascimento = criaObjetoLocalDate();
		
		Paciente paciente = new Paciente(null,
										 tfNome.getText(),
										 Long.parseLong(tfCpf.getText()),
										 dataNascimento,
										 tfCidade.getText(), tfCidade.getText(), 
										 tfRua.getText(), tfCep.getText(),
										 tfNumero.getText(), tfBairro.getText(), tfComplemento.getText(),
										 tfComorbidade.getText());
		
		PacienteDAO.getInstance().persist(paciente);

		//Faz uma busca pelo paciente que acabou de ser Persistido
		List<Paciente> pacientes = PacienteDAO.getInstance().findAll();
		Long id = 0L;
		for (Paciente paciente2 : pacientes) {
			id = paciente2.getId();
		}
		Paciente paciente1 = PacienteDAO.getInstance().getById(id);

		Coleta coleta = new Coleta(null, tfColetor.getText(),
								   TipoColeta.valueOf(cbTipoMaterialColetado.getValue().toString()), 
								   paciente1);
		
		ColetaDAO.getInstance().persist(coleta);

	}
	
	private LocalDate criaObjetoLocalDate() {
		int dia = Integer.parseInt(tfDataNascimento.getText().substring(0, 2));
		int mes = Integer.parseInt(tfDataNascimento.getText().substring(3, 5));
		int ano = Integer.parseInt(tfDataNascimento.getText().substring(6, 10));
		return LocalDate.of(ano, mes, dia);
	}
	
}
