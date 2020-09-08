package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Contrato {

	private Date dataContrato;
	private Double valorHora;
	private Integer horasContrato;
	SimpleDateFormat df = new SimpleDateFormat("MM/yyyy");
	
	public Contrato() {
	}

	public Contrato(Date dataContrato, Double valorHora, Integer horasContrato) {
		this.dataContrato = dataContrato;
		this.valorHora = valorHora;
		this.horasContrato = horasContrato;
	}

	public Date getDataContrato() {
		return dataContrato;
	}

	public void setDataContrato(Date dataContrato) {
		this.dataContrato = dataContrato;
	}

	public Double getValorHora() {
		return valorHora;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	public Integer getHorasContrato() {
		return horasContrato;
	}

	public void setHorasContrato(Integer horasContrato) {
		this.horasContrato = horasContrato;
	}
	
	
	public Double  totalValorContrato() {
		return this.valorHora * this.horasContrato ;

	}

	@Override
	public String toString() {
		return "Contrato [dataContrato=" + df.format(dataContrato) + ", valorHora=" + valorHora + ", horasContrato="
				+ horasContrato + "]";
	}
	
	
	
}
