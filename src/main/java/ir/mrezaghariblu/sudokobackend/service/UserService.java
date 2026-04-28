package ir.mrezaghariblu.sudokobackend.service;

import ir.mrezaghariblu.sudokobackend.dto.RegisterRequest;
import ir.mrezaghariblu.sudokobackend.exception.AppException;
import ir.mrezaghariblu.sudokobackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ir.mrezaghariblu.sudokobackend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException("Username already exists");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        // مقادیر پیش‌فرض صفر هستند (خودکار)
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException("User not found"));
    }
}
