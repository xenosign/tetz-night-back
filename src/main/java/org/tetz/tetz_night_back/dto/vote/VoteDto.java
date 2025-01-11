package org.tetz.tetz_night_back.dto.vote;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.tetz.tetz_night_back.entity.vote.Vote;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VoteDto {
    private String user;
    private Vote.VoteType voteType;

    // Entity -> DTO 변환 메서드
    public static VoteDto from(Vote vote) {
        return new VoteDto(
                vote.getUser(),
                vote.getVoteType()
        );
    }
}