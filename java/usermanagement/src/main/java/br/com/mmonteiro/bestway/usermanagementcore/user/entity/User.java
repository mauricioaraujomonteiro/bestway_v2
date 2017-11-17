/**
 * 
 */
package br.com.mmonteiro.bestway.usermanagementcore.user.entity;

import java.util.List;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.mmonteiro.bestway.usermanagement.core.DomainObject;
import br.com.mmonteiro.bestway.usermanagement.core.route.Route;

/**
 * @author mmont
 *
 */
@Document(collection="user")
public class User extends DomainObject
{
    private String nome;
    @Indexed(unique=true, sparse=true)
    private String email;
    private String password;
    private List<Route> routes;
    @Transient
    protected transient MongoTemplate mongoTemplate;

    public String getNome()
    {
        return nome;
    }
    public void setNome(String pNome)
    {
        nome = pNome;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String pEmail)
    {
        email = pEmail;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String pPassword)
    {
        password = pPassword;
    }
    
    public List<Route> getRoutes()
    {
        return routes;
    }
    public void setRoutes(List<Route> pRoutes)
    {
        routes = pRoutes;
    }
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (email == null)
        {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (nome == null)
        {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (password == null)
        {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }
}
