package com.infinite.jsf.insurance.controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import com.infinite.jsf.insurance.dao.InsuranceCompanyDao;
import com.infinite.jsf.insurance.daoImpl.InsuranceCompanyDaoImpl;
import com.infinite.jsf.insurance.model.InsuranceCompany;

//this controller manage the company related crud operation 
public class InsuranceCompanyController {

	private InsuranceCompanyDao companyDao = new InsuranceCompanyDaoImpl();
	private String showSuccessMessage;
	private InsuranceCompany company;

	// add company method
	public String addInsuranceCompany(InsuranceCompany company) {
		if (validateCompanyWithFacesMessage(company)) {
			this.companyDao.addCompany(company); // save company
			showSuccessMessage = "company added showsuccessfully!";
			return "showcompany?faces-redirect=true";
		}
		return null; // stay on same page, show error messages
	}

	// searchcompanyById
	public String findCompnayById(String companyId) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put("companyId", companyId);
		company = companyDao.findCompanyById(companyId);
		return "searchCompanyById?faces-redirect=true";

	}

   //show all company By Id
	public List<InsuranceCompany> findAllCompany() {
		System.out.println("findall company is called");
		return companyDao.findAllCompany();
	}

  //delete company By Id
	public String deleteCompanyById(String companyId) {
		FacesContext context = FacesContext.getCurrentInstance();
		company = companyDao.findCompanyById(companyId);
		if (company == null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"company is not found with this id " + companyId, null));
			return "not found";
		}
		System.out.println("company in controller  : " + company + "with id : " + companyId);
		companyDao.deleteCompanyById(company);
		showSuccessMessage = "company deleted showsuccessfully!";
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "company deleted succussfully!", null));
//         return "showcompany?faces-redirect=true";
		return null;
	}

  //update company
	public String updateCompanyById(InsuranceCompany company) {
		FacesContext context = FacesContext.getCurrentInstance();
		String companyId = (String) context.getExternalContext().getSessionMap().get("companyId");
		company.setCompanyId(companyId);
		System.out.println("==========================================================================");
		System.out.println(company);
		if (validateCompanyWithFacesMessage(company)) {
			showSuccessMessage = "company updated  showsuccessfully!";
			companyDao.updateCompany(company);
			return "showcompany?faces-redirect=true";
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Validation Fails!", null));
		}
		return null;
	}

  //validate company
	public boolean validateCompanyWithFacesMessage(InsuranceCompany company) {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean isValid = true;
		if (company.getName() == null || company.getName().trim().isEmpty()) {
			context.addMessage("companyForm:name",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Company name is required.", null));
			isValid = false;
		} else {
			String name = company.getName().trim();

			if (name.length() < 4) {
				context.addMessage("companyForm:name", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Company name must be at least 4 characters long.", null));
				isValid = false;
			}
		}

		if (company.getContactEmail() == null || company.getContactEmail().trim().isEmpty()) {
			context.addMessage("companyForm:email",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email is required.", null));
			isValid = false;
		} else {
			String email = company.getContactEmail().trim();

			// Regex: 4 letters at start, then allowed characters, then @gmail.com
			if (!email.matches("^[A-Za-z]{4}[A-Za-z0-9._%+-]*@gmail\\.com$")) {
				context.addMessage("companyForm:email", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Invalid email. It must start with 4 letters and end with '@gmail.com'.", null));
				isValid = false;
			}
		}

		if (company.getContactPhone() == null || company.getContactPhone().trim().isEmpty()) {
			context.addMessage("companyForm:phone",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phone number is required.", null));
			isValid = false;
		} else if (!company.getContactPhone().matches("\\d{10}")) {
			context.addMessage("companyForm:phone", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Phone number must be exactly 10 digits with no letters, spaces, or special characters.", null));
			isValid = false;
		}

		if (company.getHeadOffice() == null || company.getHeadOffice().trim().isEmpty()) {
			context.addMessage("companyForm:headOffice",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Head Office is required.", null));
			isValid = false;
		} else if (company.getHeadOffice().length() < 4) {
			context.addMessage("companyForm:headOffice", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"getHeadOffice name must be at least 4 characters.", null));
			isValid = false;
		}
		if (company.getLogoUrl() == null || company.getLogoUrl().trim().isEmpty()) {
			context.addMessage("companyForm:logoUrl",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Logo URL is required.", null));
			isValid = false;
		} else {
			String logoUrl = company.getLogoUrl().trim();
			// Check length
			if (logoUrl.length() < 4) {
				context.addMessage("companyForm:logoUrl",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Logo URL must be at least 4 characters.", null));
				isValid = false;
			}
			// Validate format: allow simple filename or optional folder + filename with
			// image extensions
			else if (!logoUrl.matches("^([\\w\\-]+/)?[\\w\\-]+\\.(jpg|jpeg|png|gif)$")) {
				context.addMessage("companyForm:logoUrl", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Logo URL must be a valid image filename with extension jpg, jpeg, png, or gif.", null));
				isValid = false;
			}
		}

		return isValid;
	}

  //	Getter setter 

	public InsuranceCompanyDao getCompanyDao() {
		return companyDao;
	}

	public void setCompanyDao(InsuranceCompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	public InsuranceCompany getCompany() {
		return company;
	}

	public void setCompany(InsuranceCompany company) {
		this.company = company;
	}

	public String getShowSuccessMessage() {
		return showSuccessMessage;
	}

	public void setShowSuccessMessage(String showSuccessMessage) {
		this.showSuccessMessage = showSuccessMessage;
	}

}
