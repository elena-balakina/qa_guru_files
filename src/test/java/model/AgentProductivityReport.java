package model;

public class AgentProductivityReport {
    private String agentName;
    private String contactsHandled;
    private String outboundCalls;
    private String inboundCalls;
    private String freeCalls;
    private String inboundEmails;
    private String outboundEmails;


    public AgentProductivityReport(){
    }

    public AgentProductivityReport(String agentName, String contactsHandled, String outboundCalls, String inboundCalls,
                                   String freeCalls, String inboundEmails, String outboundEmails) {
        this.agentName = agentName;
        this.contactsHandled = contactsHandled;
        this.outboundCalls = outboundCalls;
        this.inboundCalls = inboundCalls;
        this.freeCalls = freeCalls;
        this.inboundEmails = inboundEmails;
        this.outboundEmails = outboundEmails;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getContactsHandled() {
        return contactsHandled;
    }

    public String getOutboundCalls() {
        return outboundCalls;
    }

    public String getInboundCalls() {
        return inboundCalls;
    }

    public String getFreeCalls() {
        return freeCalls;
    }

    public String getInboundEmails() {
        return inboundEmails;
    }

    public String getOutboundEmails() {
        return outboundEmails;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public void setContactsHandled(String contactsHandled) {
        this.contactsHandled = contactsHandled;
    }

    public void setOutboundCalls(String outboundCalls) {
        this.outboundCalls = outboundCalls;
    }

    public void setInboundCalls(String inboundCalls) {
        this.inboundCalls = inboundCalls;
    }

    public void setFreeCalls(String freeCalls) {
        this.freeCalls = freeCalls;
    }

    public void setInboundEmails(String inboundEmails) {
        this.inboundEmails = inboundEmails;
    }

    public void setOutboundEmails(String outboundEmails) {
        this.outboundEmails = outboundEmails;
    }

    @Override
    public String toString() {
        return "AgentProductivityReportROW {" +
                "agentName='" + agentName + '\'' +
                ", contactsHandled='" + contactsHandled + '\'' +
                ", outboundCalls='" + outboundCalls + '\'' +
                ", inboundCalls='" + inboundCalls + '\'' +
                ", freeCalls='" + freeCalls + '\'' +
                ", inboundEmails='" + inboundEmails + '\'' +
                ", outboundEmails='" + outboundEmails + '\'' +
                '}';
    }
}
