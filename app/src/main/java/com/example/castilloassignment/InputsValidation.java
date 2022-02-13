package com.example.castilloassignment;

    import android.app.Activity;
    import android.content.Context;
    import android.view.View;
    import android.view.WindowManager;
    import android.view.inputmethod.InputMethodManager;
    import android.widget.EditText;
    import android.widget.Toast;

    import com.google.android.material.textfield.TextInputLayout;


public class InputsValidation {
        private Context context;


        public InputsValidation(Context context) {
            this.context = context;
        }

        public boolean isEditTextFilled(String string) {

            if (string.isEmpty()) {
                Toast.makeText(context, R.string.error_message_empty,
                        Toast.LENGTH_LONG).show();
                return false;
            }
            return true;

        }

        public boolean isEditTextEmail(String string) {
            if (string.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(string).matches()) {
                Toast.makeText(context, R.string.error_message_email,
                        Toast.LENGTH_LONG).show();
                return false;
            }

            return true;

        }


    }

