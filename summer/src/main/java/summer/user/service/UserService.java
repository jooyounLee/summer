package summer.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import summer.user.model.User;
import summer.user.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	@Autowired private UserRepository repository;
	@Autowired private PasswordEncoder passwordEncoder;
	
	public int create(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return repository.create(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUserName(username);
		
		// TODO : get Auth from DB
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		return new org.springframework.security.core.userdetails.User
				(user.getUsername(), user.getPassword(), authorities);
	}
}
