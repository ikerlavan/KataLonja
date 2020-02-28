package org.iker.kata.lonja.katalonja.service;

import java.util.List;

import org.iker.kata.lonja.katalonja.dominio.Mercado;
import org.springframework.stereotype.Service;

@Service
public interface MercadoService {

	List<Mercado> getMercadosInfo();
}
