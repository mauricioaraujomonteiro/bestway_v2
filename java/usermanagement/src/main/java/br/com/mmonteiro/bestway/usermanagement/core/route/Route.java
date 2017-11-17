/**
 * 
 */
package br.com.mmonteiro.bestway.usermanagement.core.route;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Indicates the routes that should be monitored in order to analyze the best way to reach the final destination.
 * @author mmont
 *
 */
@Document(collection="route")
public class Route
{
    private Coordinate fromDestination;
    private Coordinate toDestination;
    public Coordinate getFromDestination()
    {
        return fromDestination;
    }
    public void setFromDestination(Coordinate pFromDestination)
    {
        fromDestination = pFromDestination;
    }
    public Coordinate getToDestination()
    {
        return toDestination;
    }
    public void setToDestination(Coordinate pToDestination)
    {
        toDestination = pToDestination;
    }
    public boolean isActived()
    {
        return actived;
    }
    public void setActived(boolean pActived)
    {
        actived = pActived;
    }
    private boolean actived;
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (actived ? 1231 : 1237);
        result = prime * result + ((fromDestination == null) ? 0 : fromDestination.hashCode());
        result = prime * result + ((toDestination == null) ? 0 : toDestination.hashCode());
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
        Route other = (Route) obj;
        if (actived != other.actived)
            return false;
        if (fromDestination == null)
        {
            if (other.fromDestination != null)
                return false;
        } else if (!fromDestination.equals(other.fromDestination))
            return false;
        if (toDestination == null)
        {
            if (other.toDestination != null)
                return false;
        } else if (!toDestination.equals(other.toDestination))
            return false;
        return true;
    }

    
}
