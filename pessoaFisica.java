package classes;

import java.util.Objects;

public class pessoaFisica extends Contatos {
    private String CPF;
    private String dataNascimento;
    private String estadoCivil;

    public pessoaFisica() {

    }

    public pessoaFisica(String CPF, String dataNascimento, String estadoCivil) {
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
    }

    public String getCPF() {
        return CPF;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        String ret = super.toString();
        ret += "\n\nCPF: " + getCPF() + "\n";
        ret += "Data de Nascimento: " + getDataNascimento() + "\n";
        ret += "Estado civil: " + getEstadoCivil() + "\n";

        return ret;
    }

    @Override
    public void imprimirDados() {
        System.out.println("\n***DADOS PESSOA FISICA***\n");
        System.out.println(toString());
        System.out.println();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        pessoaFisica other = (pessoaFisica) obj;
        return Objects.equals(CPF, other.CPF);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CPF);
    }
}
