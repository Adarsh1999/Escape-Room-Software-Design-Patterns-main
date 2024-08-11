package edu.neu.csye7374.StateObjectAdapter;

import edu.neu.csye7374.APIs.PlayerStateAPI;
import edu.neu.csye7374.APIs.PlayerStateAdapterAPI;

public class StateObjAdapter implements PlayerStateAdapterAPI {

    private final PlayerStateAPI oldApiObj;

    public StateObjAdapter(PlayerStateAPI oldApiObj) {
        super();
        this.oldApiObj = oldApiObj;
    }
    public void EntryStateAdapter() {
        this.oldApiObj.EntryStateOn();
        this.oldApiObj.BeginnerStateOn();
    }

    public void IntermediateStateAdapter() {
        this.oldApiObj.IntermediateStateOn();
    }

    public void ExitStateAdapter() {
        this.oldApiObj.AdvancedStateOn();
        this.oldApiObj.ExitStateOn();
    }
}
