package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import entities.nivel.NivelProfissional;

public class Trabalhador {
	private String nome;
	private NivelProfissional nivel;
	private Double salario;
	private ArrayList<Contrato> contratos = new ArrayList<>();
	private Departamento departamento;

	public Trabalhador() {

	}

	public Trabalhador(String nome, String nivel, Double salario, String dpt) {
		this.nome = nome;
		this.nivel = NivelProfissional.valueOf(nivel);
		this.salario = salario;
		departamento = new Departamento(dpt);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelProfissional getNivel() {
		return nivel;
	}

	public void setNivel(NivelProfissional nivel) {
		this.nivel = nivel;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public ArrayList<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(ArrayList<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public void addContrato(String data, Double valor, Integer qtdHoras ) {

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date dt = df.parse(data);
			this.contratos.add(new Contrato(dt, valor, qtdHoras));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void removeContrato(String data)  {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date d;

		try {
			Iterator<Contrato> itr = this.contratos.iterator();
			d = df.parse(data);
			while (itr.hasNext()) {
				Contrato cRem = itr.next();
				if (cRem.getDataContrato().equals(d)) {
					itr.remove();
					System.out.println("Contrato Removido\n");
				}
			}

		} catch (ParseException e) {
			System.out.println(" Erro - Data invalida ");
		}

	}

	public Double renda(String mesAno) {
		SimpleDateFormat df = new SimpleDateFormat("MM/yyyy");
		Date d;
		Double renda = 0.0;
		try {
			d = df.parse(mesAno);
			
			for (Contrato con : contratos) {
				String xa = df.format(con.getDataContrato());
				if(xa.equals(df.format(d))) {
					renda += con.totalValorContrato();
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return this.salario + renda;
	}

	@Override
	public String toString() {
		return " Trabalhador:\n nome= " + nome + "\n nivel= " + nivel + "\n salario= " + salario + "\n departamento= "
				+ departamento.getNome();
	}



}
