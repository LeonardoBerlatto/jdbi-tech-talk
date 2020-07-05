

SELECT "user".id as userId,
       "user".name as userName,
       party.id as partyId,
       party.description as partyName
FROM party
         INNER JOIN "user" ON party.user_id = "user".id
WHERE  party.id = :id