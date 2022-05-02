package dat.carport.model.persistence;

import dat.carport.model.entities.User;
import dat.carport.model.exceptions.DatabaseException;

public interface IUserMapper
{
    public User login(String email, String kodeord) throws DatabaseException;
    public User createUser(String username, String password, String role) throws DatabaseException;
}
