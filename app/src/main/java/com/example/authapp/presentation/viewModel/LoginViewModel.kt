import androidx.lifecycle.ViewModel
import com.example.authapp.data.Repository.LoginRepository
import com.example.authapp.utils.Result

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {
    fun loginUser(email: String, password: String, callback: (Result<Boolean>) -> Unit) {
        loginRepository.loginUser(email, password, callback)
    }
}

