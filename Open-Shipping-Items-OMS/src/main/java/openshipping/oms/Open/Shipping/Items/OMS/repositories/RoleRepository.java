package openshipping.oms.Open.Shipping.Items.OMS.repositories;

import openshipping.oms.Open.Shipping.Items.OMS.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
