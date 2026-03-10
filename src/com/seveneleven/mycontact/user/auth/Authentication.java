//Authentication strategy interface

package com.seveneleven.mycontact.user.auth;
import com.seveneleven.mycontact.user.model.User;

import java.util.Optional;

public interface Authentication {
	Optional<User> login(String email, String password);
}
