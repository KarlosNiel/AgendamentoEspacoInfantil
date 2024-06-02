public class AgendamentoAdm {
    private Administrador adm;
    private Cliente cliente;

    public void AbrirEvento(String evento) {
        Datas.listaEventosGerais.add(evento);
    }

    public void fecharEvento(String evento){
        Datas.listaEventosGerais.remove(evento);
    }

    public void limparInscritosEventos() {
        for (String limparEventos: Datas.listaInscricaoNosEventos) {
            Datas.listaInscricaoNosEventos.remove(limparEventos);
        }
    }

    public void Agendar(){
    }

    public void Remover(){
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Administrador getAdm() {
        return adm;
    }

    public void setAdm(Administrador adm) {
        this.adm = adm;
    }


}