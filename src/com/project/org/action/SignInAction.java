package com.project.org.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.org.model.SignIn;
import com.project.org.service.SignInService;

import java.util.Map;

public class SignInAction extends ActionSupport {
    protected SignInService signInService;
    private SignIn signIn;

    public String execute() throws Exception {
        boolean validated = false;
        Map session = ActionContext.getContext().getSession();
        SignIn signIn1 = null;
        signIn1 = (SignIn) session.get("signIn");
        if (signIn1 == null) {
            signIn1 = signInService.find(signIn.getStudent().getSno(), signIn.getStupwd());
            if (signIn1 != null) {
                session.put("signIn", signIn1);
                validated = true;
            }
        } else {
            validated = true;
        }
        if (validated) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public SignIn getSignIn() {
        return signIn;
    }

    public void setSignIn(SignIn signIn) {
        this.signIn = signIn;
    }

    public SignInService getSignInService() {
        return signInService;
    }

    public void setSignInService(SignInService signInService) {
        this.signInService = signInService;
    }

}
