SELECT
    EXISTS (
            SELECT
                1
            FROM
                "user"
            WHERE
                    "name" = :name)