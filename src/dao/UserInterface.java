package dao;
import Beans.User;
import java.util.List;
public interface UserInterface {
	public void getUserById(int id);
    List<User> getAllUsers();
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
}