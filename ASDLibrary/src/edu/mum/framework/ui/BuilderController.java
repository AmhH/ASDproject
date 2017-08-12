package edu.mum.framework.ui;

import java.util.List;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public interface BuilderController {
	public void loadConcreteProdList();
	public void loadCurrentType();
	public AnchorPane getPorductLayout();
	public List<TextField> getDynamicInputs();
}
