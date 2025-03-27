package api_gestao_freelancers.dto;


public record UserDto(String fullName, String cpfCnpj, String email,  String password, boolean isClient, boolean isFreelancer, String mainProfile) {
}
