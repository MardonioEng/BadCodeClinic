package br.com.ifce.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import br.com.ifce.model.enums.TipoColeta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class CadastroController implements Initializable {

	@FXML
	private ComboBox<String> cbSexo;
	@FXML
	private ComboBox<TipoColeta> cbTipoMaterialColetado;

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
	
}
