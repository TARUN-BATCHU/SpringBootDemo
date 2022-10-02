package tarun.SpringBootDemo.SpringBootDemo.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

//    public void updateUser(String UserId, User user)
//    {
//        for(int i=0;i<2;i++)
//        {
//            User u = useraa.get(i);
//            if(u.getUserId().equals(UserId))
//            {
//                useraa.set(i,user);
//                return;
//            }
//
//        }
//    }
}
