
public class IMC_Info {

    private IMC_Error errors;
    private int init_states;
    private int final_states;
    private int trans_states;
    private int non_det_states;
    private int unstable_states;

    public IMC_Info() {
        errors = new IMC_Error();
        init_states = final_states = trans_states = non_det_states = unstable_states = 0;
    }

    public IMC_Info(IMC_Error errors, int init_states, int final_states, int trans_states, int non_det_states, int unstable_states) {
        this.errors = errors.clone();
        this.init_states = init_states;
        this.final_states = final_states;
        this.trans_states = trans_states;
        this.non_det_states = non_det_states;
        this.unstable_states = unstable_states;
    }

    public void incInitStates() {
        this.init_states++;
    }

    public void incFinalStates() {
        this.final_states++;
    }

    public void incTransStates() {
        this.trans_states++;
    }

    public void incNonDetStates() {
        this.non_det_states++;
    }

    public void incUnstableStates() {
        this.unstable_states++;
    }


    public IMC_Error getErrors() {
        return errors.clone();
    }

    public int getInit_states() {
        return init_states;
    }

    public int getFinal_states() {
        return final_states;
    }

    public int getTrans_states() {
        return trans_states;
    }

    public int getNon_det_states() {
        return non_det_states;
    }

    public int getUnstable_states() {
        return unstable_states;
    }


}
