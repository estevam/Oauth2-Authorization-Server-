

INSERT INTO oauth2_user (username, password,created,is_account_expired, is_account_locked, is_credentials_expired, is_enabled) 
VALUES ('estevam@gmail.com','$2a$10$wAUr3pLHVlCKUBp2nv8aHe0GkX.YwDcErceB5v3GaMglLUtqGXR7u',CURRENT_TIMESTAMP(),FALSE,FALSE,FALSE,FALSE);
--INSERT INTO oauth2_user (username, password,created) VALUES ('ilse@gmail.com' ,'$2a$10$CCabgPB.KlDvBqE7i0.5kuWa4Y1YTlP.1tAXlfMolDXT8ZtGC.RpG', CURRENT_TIMESTAMP());
--INSERT INTO oauth2_user (username, password,created) VALUES ('clara@gmail.com','$2a$10$7lAVoYnQVgqmQySWL4cyauWpq.tVr.3lzJUZGarO34Jhypwh.3/ge',CURRENT_TIMESTAMP());
--INSERT INTO oauth2_user (username, password,created) VALUES ('isabella@gmail.com','$2a$10$hI/25ZBLc/aulJKtGOu.KeZvNbAuv1/fiJx2cjxTfY5.wZsOdbZgO',CURRENT_TIMESTAMP());

INSERT INTO oauth2_authority (created,authority) VALUES (CURRENT_TIMESTAMP(),'ROLE_ADMIN');
INSERT INTO oauth2_authority (created,authority) VALUES (CURRENT_TIMESTAMP(),'ROLE_EDITOR');
INSERT INTO oauth2_authority (created,authority) VALUES (CURRENT_TIMESTAMP(),'ROLE_MANAGER');
INSERT INTO oauth2_authority (created,authority) VALUES (CURRENT_TIMESTAMP(),'ROLE_USER');

INSERT INTO oauth2_user_authority(user_id, authority_id) VALUES (1,1);
--INSERT INTO oauth2_user_authority(user_id, authority_id) VALUES (2,2);


 CREATE TABLE oauth2_authorization_consent (
    registered_client_id varchar(100) NOT NULL,
    principal_name varchar(200) NOT NULL,
    authorities varchar(1000) NOT NULL,
    PRIMARY KEY (registered_client_id, principal_name)
);

CREATE TABLE oauth2_registered_client (
    id varchar(100) NOT NULL,
    client_id varchar(100) NOT NULL,
    client_id_issued_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
    client_secret varchar(200) DEFAULT NULL,
    client_secret_expires_at timestamp DEFAULT NULL,
    client_name varchar(200) NOT NULL,
    client_authentication_methods varchar(1000) NOT NULL,
    authorization_grant_types varchar(1000) NOT NULL,
    redirect_uris varchar(1000) DEFAULT NULL,
    post_logout_redirect_uris varchar(1000) DEFAULT NULL,
    scopes varchar(1000) NOT NULL,
    client_settings varchar(2000) NOT NULL,
    token_settings varchar(2000) NOT NULL,
    PRIMARY KEY (id)
);



CREATE TABLE oauth2_authorization (
    id varchar(100) NOT NULL,
    registered_client_id varchar(100) NOT NULL,
    principal_name varchar(200) NOT NULL,
    authorization_grant_type varchar(100) NOT NULL,
    authorized_scopes varchar(1000) DEFAULT NULL,
    attributes blob DEFAULT NULL,
    state varchar(500) DEFAULT NULL,
    authorization_code_value blob DEFAULT NULL,
    authorization_code_issued_at timestamp DEFAULT NULL,
    authorization_code_expires_at timestamp DEFAULT NULL,
    authorization_code_metadata blob DEFAULT NULL,
    access_token_value blob DEFAULT NULL,
    access_token_issued_at timestamp DEFAULT NULL,
    access_token_expires_at timestamp DEFAULT NULL,
    access_token_metadata blob DEFAULT NULL,
    access_token_type varchar(100) DEFAULT NULL,
    access_token_scopes varchar(1000) DEFAULT NULL,
    oidc_id_token_value blob DEFAULT NULL,
    oidc_id_token_issued_at timestamp DEFAULT NULL,
    oidc_id_token_expires_at timestamp DEFAULT NULL,
    oidc_id_token_metadata blob DEFAULT NULL,
    refresh_token_value blob DEFAULT NULL,
    refresh_token_issued_at timestamp DEFAULT NULL,
    refresh_token_expires_at timestamp DEFAULT NULL,
    refresh_token_metadata blob DEFAULT NULL,
    user_code_value blob DEFAULT NULL,
    user_code_issued_at timestamp DEFAULT NULL,
    user_code_expires_at timestamp DEFAULT NULL,
    user_code_metadata blob DEFAULT NULL,
    device_code_value blob DEFAULT NULL,
    device_code_issued_at timestamp DEFAULT NULL,
    device_code_expires_at timestamp DEFAULT NULL,
    device_code_metadata blob DEFAULT NULL,
    PRIMARY KEY (id)
);
