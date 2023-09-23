package classes;

import java.util.Objects;

public class pessoaJuridica extends Contatos {
    private String CNPJ;
    private String inscricaoEstadual;
    private String razaoSocial;

    public pessoaJuridica() {

    }

    public pessoaJuridica(String CNPJ, String inscricaoEstadual, String razaoSocial) {
        this.CNPJ = CNPJ;
        this.inscricaoEstadual = inscricaoEstadual;
        this.razaoSocial = razaoSocial;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String toString() {
        String ret = super.toString();
        ret += "\n\nCNPJ: " + getCNPJ() + "\n";
        ret += "Inscricao Estadual: " + getInscricaoEstadual() + "\n";
        ret += "Razao Social: " + getRazaoSocial() + "\n";

        return ret;
    }

    @Override
    public void imprimirDados() {
        System.out.println("\n***DADOS PESSOA JURIDICA***\n");
        System.out.println(toString());
        System.out.println();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        pessoaJuridica other = (pessoaJuridica) obj;
        return Objects.equals(CNPJ, other.CNPJ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CNPJ);
    }
}
