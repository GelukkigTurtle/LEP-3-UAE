package main;

public class Evaluacion {
	
	private double eval1;
	private double eval2;
	private double eval3;
	private double eval4;
	private double nota_final;
	
	public Evaluacion(double eval1, double eval2, double eval3, double eval4, double nota_final) {
		super();
		this.eval1 = eval1;
		this.eval2 = eval2;
		this.eval3 = eval3;
		this.eval4 = eval4;
		this.nota_final = nota_final;
	}

	public double getEval1() {
		return eval1;
	}

	public void setEval1(double eval1) {
		this.eval1 = eval1;
	}

	public double getEval2() {
		return eval2;
	}

	public void setEval2(double eval2) {
		this.eval2 = eval2;
	}

	public double getEval3() {
		return eval3;
	}

	public void setEval3(double eval3) {
		this.eval3 = eval3;
	}

	public double getEval4() {
		return eval4;
	}

	public void setEval4(double eval4) {
		this.eval4 = eval4;
	}

	public double getNota_final() {
		return nota_final;
	}

	public void setNota_final(double nota_final) {
		this.nota_final = nota_final;
	}
	
	
}
