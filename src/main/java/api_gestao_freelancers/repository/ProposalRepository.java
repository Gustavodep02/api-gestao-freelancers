package api_gestao_freelancers.repository;

import api_gestao_freelancers.entity.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
}
