/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Bean.TemperaturaBean;
import Modelo.Temperatura;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class TemperaturaDAO
{

    private String mensagem;
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void cadastrarTemperatura(Temperatura temperatura)
    {
        this.mensagem = "";
        try
        {
            session.beginTransaction();
            session.save(temperatura);
            session.getTransaction().commit();
            session.close();
            this.mensagem = "Temperatura Cadastrada Com Sucesso!!!";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro de Gravação no BD";
            System.out.println(e);
        }
    }

    public List<Temperatura> pesquisarTemperaturaPorId(Temperatura temperatura)
    {
        this.mensagem = "";
        List<Temperatura> listaTemperatura = new ArrayList<>();
        try
        {
            Query q = session.createQuery("from Temperatura t where t.valorTemperatura = :valorTemperatura");
            //from temperatura t where t.valor_temperatura like :valor_temperatura
                    
            q.setParameter("valorTemperatura", temperatura.getValorTemperatura() + "%");
            listaTemperatura = (List<Temperatura>) q.list();//.get(0)
        }
        catch (Exception e)
        {
            this.mensagem = "erro de leitura no BD";
            System.out.println(e);
        }
        return listaTemperatura;
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String mensagem)
    {
        this.mensagem = mensagem;
    }

}
