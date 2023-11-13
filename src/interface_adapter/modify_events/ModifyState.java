package interface_adapter.modify_events;

import interface_adapter.create_events.CreateEventState;

public class ModifyState {

    private String name = "";
    private String nameError = null;
    private String start= "";
    private String startError = null;
    private String end = "";
    private String endError = null;
    private String currency = "";
    private String currencyError = null;
    private String summary = "";
    private String summaryError = null;
    private Boolean isPrivate = false;
    private Boolean isPrivateError = null;

    public ModifyState(ModifyState copy){
        this.name = copy.getName();
        this.nameError = copy.getNameError();
        this.start = copy.getStart();
        this.startError = copy.getStartError();
        this.end = copy.getEnd();
        this.endError = copy.getEndError();
        this.currency = copy.getCurrency();
        this.currencyError = copy.getCurrencyError();
        this.summary = copy.getSummary();
        this.summaryError = copy.getSummaryError();
        this.isPrivate = copy.getIsPrivate();
        this.isPrivateError = copy.getIsPrivateError();
    }

    public ModifyState() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStartError() {
        return startError;
    }

    public void setStartError(String startError) {
        this.startError = startError;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getEndError() {
        return endError;
    }

    public void setEndError(String endError) {
        this.endError = endError;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencyError() {
        return currencyError;
    }

    public void setCurrencyError(String currencyError) {
        this.currencyError = currencyError;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummaryError() {
        return summaryError;
    }

    public void setSummaryError(String summaryError) {
        this.summaryError = summaryError;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public Boolean getIsPrivateError() {
        return isPrivateError;
    }

    public void setIsPrivateError(Boolean isPrivateError) {
        this.isPrivateError = isPrivateError;
    }


}
