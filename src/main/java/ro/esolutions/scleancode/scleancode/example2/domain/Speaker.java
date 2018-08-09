package ro.esolutions.scleancode.scleancode.example2.domain;

import ro.esolutions.scleancode.scleancode.example2.exception.NoSessionsApprovedException;
import ro.esolutions.scleancode.scleancode.example2.exception.SpeakerDoesntMeetRequirementsException;

import java.util.Arrays;
import java.util.List;

public class Speaker {
    private String firstName;
    private String lastName;
    private String email;
    private int YearExperience;
    private boolean hasBlog;
    private String blogURL;
    private WebBrowser browser;
    private List<String> certifications;
    private String employer;
    private int registrationFee;
    private List<Session> sessions;
    public int RegistrationFee;

    public void ValidateExceptions() {
        if (this.firstName.isEmpty()) {
            throw new IllegalArgumentException("First Name is required");
        }
        if (this.lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name is required");
        }

        if (this.email.isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }

    }

    private void validateFeatures() throws Exception {

        boolean isGood = false;
        boolean isNavigatorDomain = false;
        boolean isAcepted = false;

        isGood = isGood();
        isNavigatorDomain = IsNavigatorDomainValidate();

        isAcepted = isGood || !isNavigatorDomain;

        if (!isAcepted) {
            throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our abitrary and capricious standards.");
        }
    }

    private boolean getSessionByOldTechnologies(Session session) {
        String[] oldTechnologies = new String[]{"Cobol", "Punch Cards", "Commodore", "VBScript"};

        for (String oldTechnology : oldTechnologies) {

            if (session.getTitle().contains(oldTechnology) || session.getDescription().contains(oldTechnology)) {
                return true;
            }
        }

        return false;
    }


    private void validateSession() throws Exception {

        boolean Approved = true;

        if (this.sessions.isEmpty()) {
            throw new IllegalArgumentException("Can't register speaker with no sessions to present.");
        }

        for (Session session : sessions) {

            if (!getSessionByOldTechnologies(session)) {
                session.setApproved(true);
            } else {
                Approved = false;
                break;
            }
        }

        if (!Approved) {
            throw new NoSessionsApprovedException("No sessions approved.");
        }
    }


    private boolean isGood() {

        List<String> employersList = Arrays.asList("Pluralsight", "Microsoft", "Google", "Fog Creek Software", "37Signals", "Telerik");
        int numberCertifications = 3;
        int maxNumberYearsExperience = 10;

        return ((this.YearExperience > maxNumberYearsExperience || this.hasBlog
                || this.certifications.size() > numberCertifications || employersList.contains(this.employer)));
    }

    private boolean IsNavigatorDomainValidate() {

        List<String> domains = Arrays.asList("aol.com", "hotmail.com", "prodigy.com", "compuserve.com");

        int validBrowserVersion = 9;
        String[] splitEmail = this.email.split("@");
        String emailDomain = splitEmail[splitEmail.length - 1];

        return domains.contains(emailDomain)
                || (browser.getName() == WebBrowser.BrowserName.InternetExplorer && browser.getMajorVersion() < validBrowserVersion);
    }


    public int getRegistrationFee(int /*?*/ Experience) {
        int RegistrationFee = 0;
        if (Experience <= 0) {
            RegistrationFee = 500;
        }
        if (Experience >= 2 && Experience <= 3) {
            RegistrationFee = 250;
        } else if (Experience >= 4 && Experience <= 5) {
            RegistrationFee = 100;
        } else if (Experience >= 6 && Experience <= 9) {
            RegistrationFee = 50;
        } else {
            RegistrationFee = 0;
        }
        return RegistrationFee;
    }

    public Integer register(IRepository repository) throws Exception {

        ValidateExceptions();
        validateFeatures();
        validateSession();

        RegistrationFee = getRegistrationFee(YearExperience);

        return repository.saveSpeaker(this);

    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getExp() {
        return YearExperience;
    }

    public void setExp(int YearExperience) {
        this.YearExperience = YearExperience;
    }

    public boolean isHasBlog() {
        return hasBlog;
    }

    public void setHasBlog(boolean hasBlog) {
        this.hasBlog = hasBlog;
    }

    public String getBlogURL() {
        return blogURL;
    }

    public void setBlogURL(String blogURL) {
        this.blogURL = blogURL;
    }

    public WebBrowser getBrowser() {
        return browser;
    }

    public void setBrowser(WebBrowser browser) {
        this.browser = browser;
    }

    public List<String> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<String> certifications) {
        this.certifications = certifications;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    //public int getRegistrationFee() {
    //	return registrationFee;
    //}

    public void setRegistrationFee(int registrationFee) {
        this.registrationFee = registrationFee;
    }
}
