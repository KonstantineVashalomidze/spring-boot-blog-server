package com.sopromadze.blogapi.config;

import com.sopromadze.blogapi.security.UserPrincipal;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableMongoAuditing(auditorAwareRef = "auditorAwareImpl")
public class AuditingConfig {

	@Bean("auditorAwareImpl")  // Explicitly name the bean
	public AuditorAware<ObjectId> auditorAwareImpl() {  // Change method name
		return new AuditorAwareImpl();
	}
}

class AuditorAwareImpl implements AuditorAware<ObjectId> {

	@Override
	public @NonNull Optional<ObjectId> getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
			return Optional.empty();
		}
		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		return Optional.ofNullable(userPrincipal.getId());
	}
}
