/**
 * 
 */
package br.com.mmonteiro.bestway.usermanagement.core.route;

/**
 * Represents the coordinates in the world.
 * @author mmont
 *
 */
public class Coordinate
{
    private String latitude;
    private String longitude;
    
    public Coordinate(){};
    
    /**
     * @param latitude
     * @param longitude
     */
    public Coordinate(String latitude, String longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public String getLatitude()
    {
        return latitude;
    }
    public void setLatitude(String pLatitude)
    {
        latitude = pLatitude;
    }
    public String getLongitude()
    {
        return longitude;
    }
    public void setLongitude(String pLongitude)
    {
        longitude = pLongitude;
    }
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
        result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
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
        Coordinate other = (Coordinate) obj;
        if (latitude == null)
        {
            if (other.latitude != null)
                return false;
        } else if (!latitude.equals(other.latitude))
            return false;
        if (longitude == null)
        {
            if (other.longitude != null)
                return false;
        } else if (!longitude.equals(other.longitude))
            return false;
        return true;
    }
}
