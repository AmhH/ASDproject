package edu.mum.app.dao;

import edu.mum.app.domain.Audio;
import edu.mum.framework.dao.impl.AProductDaoImpl;

public class AudioDao extends AProductDaoImpl<Audio>{

	public AudioDao() {
		super(Audio.class, Audio.class.getSimpleName());
	}
}
