package edu.mum.framework.ui;

import java.lang.reflect.Field;
import java.util.List;

public interface UIBuildObserver {
	
	public void buildForm(BuilderController bc, List<Field> params);

}
