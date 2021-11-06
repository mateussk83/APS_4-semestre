package Bean;

import Controle.Controle;
import Modelo.Estaticos;
import Modelo.Serial;
import Modelo.Umidade;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;

/**
 *
 * @author 55159
 */
@ManagedBean
@RequestScoped
@ViewScoped
public class UmidadeBean
{

    private Integer cod;
    private double valor;

    public Integer getCod()
    {
        return cod;
    }

    public void setCod(Integer cod)
    {
        this.cod = cod;
    }

    public double getValor()
    {
        Serial serial = new Serial();
        serial.iniciaSerial();
        Controle controle = new Controle();
        //FAZER TIMER PARA ATUALIZAR EM REALTIME
        controle.cadastrarUmidade();
        Umidade umidade = controle.pesquisarUmidadePorId(Estaticos.umidade.getCodUmidade());
        
        serial.close();
        return umidade.getValorUmidade();
    }

    public void setValor(double valor)
    {
        this.valor = valor;
    }
    

    public UmidadeBean()
    {
    }

}
