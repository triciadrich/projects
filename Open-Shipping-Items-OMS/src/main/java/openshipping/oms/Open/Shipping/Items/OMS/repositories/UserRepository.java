package openshipping.oms.Open.Shipping.Items.OMS.repositories;

import openshipping.oms.Open.Shipping.Items.OMS.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

}
