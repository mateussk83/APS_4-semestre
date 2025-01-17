package Controle;

import Validacao.Validacao;
import Modelo.Temperatura;
import Bean.PrecipitacaoBean;
import DAL.TemperaturaDAO;
import DAL.PrecipitacaoDAO;
import DAL.UmidadeDAO;
import Modelo.Estaticos;
import Modelo.Precipitacao;
import Modelo.Protocolo;
import Modelo.Umidade;
import java.util.ArrayList;
import java.util.List;

public class Controle
{

    private Controle controle;
    private String mensagem;

    public void cadastrarPrecipitacao()
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarValorPrecipitacao(Protocolo.precipitacao);
        if (validacao.getMensagem().equals(""))
        {
            PrecipitacaoDAO precipitacaoDAO = new PrecipitacaoDAO();
            Estaticos.precipitacao.setValorPrecipitacao(validacao.getValorPrecipitacao());
            precipitacaoDAO.cadastrarPrecipitacao(Estaticos.precipitacao);
            this.mensagem = precipitacaoDAO.getMensagem();
        }
        else
        {
            this.mensagem = validacao.getMensagem();
        }
    }

    public void cadastrarTemperatura()
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarValorTemperatura(Protocolo.temperatura);
        if (validacao.getMensagem().equals(""))
        {
            TemperaturaDAO temperaturaDAO = new TemperaturaDAO();
            Estaticos.temperatura.setValorTemperatura(validacao.getValorTemperatura());
            temperaturaDAO.cadastrarTemperatura(Estaticos.temperatura);
            this.mensagem = temperaturaDAO.getMensagem();
        }
        else
        {
            this.mensagem = validacao.getMensagem();
        }
    }

    public void cadastrarUmidade()
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarValorUmidade(Protocolo.umidade);
        if (validacao.getMensagem().equals(""))
        {
            UmidadeDAO umidadeDAO = new UmidadeDAO();
            Estaticos.umidade.setValorUmidade(validacao.getValorUmidade());
            umidadeDAO.cadastrarUmidade(Estaticos.umidade);
            this.mensagem = umidadeDAO.getMensagem();
        }
        else
        {
            this.mensagem = validacao.getMensagem();
        }
    }

    public Temperatura pesquisarTemperaturaPorId(Integer codTemperatura)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarCodTemperatura(codTemperatura);
        Temperatura temperatura = new Temperatura();
        if (validacao.getMensagem().equals(""))
        {
            temperatura.setCodTemperatura(validacao.getCodTemperatura());
            TemperaturaDAO temperaturaDAO = new TemperaturaDAO();
            temperatura = temperaturaDAO.pesquisarTemperaturaPorId(temperatura);
            this.mensagem = temperaturaDAO.getMensagem();
        }
        else
        {
            this.mensagem = validacao.getMensagem();
        }

        return temperatura;
    }

    public Precipitacao pesquisarPrecipitacaoPorId(Integer codPrecipitacao)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarCodPrecipitacao(codPrecipitacao);
        Precipitacao precipitacao = new Precipitacao();
        if (validacao.getMensagem().equals(""))
        {
            precipitacao.setCodPrecipitacao(validacao.getCodPrecipitacao());
            PrecipitacaoDAO precipitacaoDAO = new PrecipitacaoDAO();
            precipitacao = precipitacaoDAO.pesquisarPrecipitacaoPorId(precipitacao);
            this.mensagem = precipitacaoDAO.getMensagem();
        }
        else
        {
            this.mensagem = validacao.getMensagem();
        }
        return precipitacao;
    }

    public Umidade pesquisarUmidadePorId(Integer codUmidade)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarCodUmidade(codUmidade);
        Umidade umidade = new Umidade();
        if (validacao.getMensagem().equals(""))
        {
            umidade.setCodUmidade(validacao.getCodUmidade());
            UmidadeDAO umidadeDAO = new UmidadeDAO();
            umidade = umidadeDAO.pesquisarUmidadePorId(umidade);
            this.mensagem = umidadeDAO.getMensagem();
        }
        else
        {
            this.mensagem = validacao.getMensagem();
        }
        return umidade;
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String mensagem)
    {
        this.mensagem = mensagem;
    }

    public Controle getControle()
    {
        return controle;
    }

    public void setControle(Controle controle)
    {
        this.controle = controle;
    }

}
