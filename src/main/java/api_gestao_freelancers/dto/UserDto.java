package api_gestao_freelancers.dto;


import api_gestao_freelancers.enums.MainProfile;

public record UserDto(String fullName, String cpfCnpj, String email, String password, boolean isClient, boolean isFreelancer, MainProfile mainProfile) {
}
