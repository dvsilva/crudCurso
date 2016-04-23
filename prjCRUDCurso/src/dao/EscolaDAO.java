package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import entity.Curso;
import exception.DaoException;

public class EscolaDAO {

	private Map<Integer, Curso> cursos;

	private static EscolaDAO instance;

	public EscolaDAO() {
		cursos = new HashMap<Integer, Curso>();
		//criamos um curso aqui para exercitar a operação de busca
		Curso curso = new Curso(99, "SI");
		try {
			this.addCurso(curso);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	public static EscolaDAO getInstance() {
		if (instance == null) {
			instance = new EscolaDAO();
		}
		return instance;
	}

	public void addCurso(Curso c) throws DaoException {
		cursos.put(c.getCodigo(), c);
		getCurso(c.getCodigo());
	}

	public Curso updateCurso(Curso cursoNovo) throws DaoException {
		cursos.put(cursoNovo.getCodigo(), cursoNovo);
		return cursoNovo;
	}

	public Curso getCurso(int codCurso) throws DaoException {
		if (cursos.get(codCurso) == null) {
			throw new DaoException("");
		}
		Curso curso = cursos.get(codCurso);
		return curso;

	}

	//Não utilizando ainda
	public Collection<Curso> getCursos() {
		return cursos.values();
	}

	public void removeCurso(int codCurso) throws DaoException {
		if (cursos.get(codCurso) == null) {
			throw new DaoException("");
		}
		cursos.remove(codCurso);
	}

}