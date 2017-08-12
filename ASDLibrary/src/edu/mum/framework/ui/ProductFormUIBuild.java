package edu.mum.framework.ui;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class ProductFormUIBuild implements UIBuildObserver {

	@Override
	public void buildForm(BuilderController bc, List<Field> filteredParams){
		
		double vpos = 147; // + 56
		double hpos = 509; // + 217 = 726
		
		
		for(int i = 0; i < filteredParams.size(); i++) {
			if(!Modifier.isFinal(filteredParams.get(i).getModifiers())) {
				TextField dynamicField = new TextField();
				bc.getPorductLayout().getChildren().add(dynamicField);
				dynamicField.setFont(new Font("Open Sans", 16));
				dynamicField.setId(filteredParams.get(i).getName());
				dynamicField.resizeRelocate(hpos, vpos, 200, 34);
				dynamicField.setPromptText(filteredParams.get(i).getName());
				dynamicField.setVisible(true);
				bc.getDynamicInputs().add(dynamicField);
			
				hpos = (i == 0 || (i%2 ==0)) ? 726 : 509;
				vpos = (i%2 != 0) ? vpos + 56 : vpos;
			}
		}
		
		
		
	}

}
