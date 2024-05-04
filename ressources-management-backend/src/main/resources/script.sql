-- we don't know how to generate root <with-no-name> (class Root) :(

grant select on performance_schema.* to 'mysql.session'@localhost;

grant trigger on sys.* to 'mysql.sys'@localhost;

grant alter, alter routine, create, create routine, create temporary tables, create user, create view, delete, drop, event, execute, index, insert, lock tables, process, references, reload, replication client, replication slave, replication_applier, role_admin, select, show databases, show view, trigger, update, grant option on *.* to avnadmin;

grant process, replication client, select on *.* to metrics_user_datadog@'::1';

grant process, replication client, select on *.* to metrics_user_telegraf@'::1';

grant audit_abort_exempt, firewall_exempt, select, system_user on *.* to 'mysql.infoschema'@localhost;

grant audit_abort_exempt, backup_admin, clone_admin, connection_admin, firewall_exempt, persist_ro_variables_admin, session_variables_admin, shutdown, super, system_user, system_variables_admin on *.* to 'mysql.session'@localhost;

grant audit_abort_exempt, firewall_exempt, system_user on *.* to 'mysql.sys'@localhost;

grant replication slave, service_connection_admin on *.* to repluser;

grant alter, alter routine, application_password_admin, audit_admin, authentication_policy_admin, backup_admin, binlog_admin, binlog_encryption_admin, clone_admin, connection_admin, create, create role, create routine, create tablespace, create temporary tables, create user, create view, delete, drop, drop role, encryption_key_admin, event, execute, file, flush_optimizer_costs, flush_status, flush_tables, flush_user_resources, group_replication_admin, group_replication_stream, index, innodb_redo_log_archive, innodb_redo_log_enable, insert, lock tables, passwordless_user_admin, persist_ro_variables_admin, process, references, reload, replication client, replication slave, replication_applier, replication_slave_admin, resource_group_admin, resource_group_user, role_admin, select, sensitive_variables_observer, service_connection_admin, session_variables_admin, set_user_id, show databases, show view, show_routine, shutdown, super, system_user, system_variables_admin, table_encryption_admin, trigger, update, xa_recover_admin, grant option on *.* to root@'%:%';

create table appel_offre
(
    id         bigint auto_increment
        primary key,
    date_debut datetime(6) null,
    date_fin   datetime(6) null
);

create table departement
(
    id            bigint auto_increment
        primary key,
    nom           varchar(255) null,
    enseignant_id bigint       null,
    enseigant_id  bigint       null,
    constraint UK_gq1hjghrdxr9skwv9i0sx1fls
        unique (enseignant_id)
);

create table user
(
    dtype            varchar(31)      not null,
    id               bigint auto_increment
        primary key,
    email            varchar(255)     null,
    nom              varchar(255)     null,
    password         varchar(255)     null,
    prenom           varchar(255)     null,
    role             tinyint          null,
    adresse          varchar(255)     null,
    lieu             varchar(255)     null,
    nom_boss         varchar(255)     null,
    nom_societe      varchar(255)     null,
    prenom_boss      varchar(255)     null,
    site_internet    varchar(255)     null,
    departement_id   bigint           null,
    is_black_listed  bit default b'0' null,
    motif_black_list varchar(255)     null,
    isblack_listed   bit              null,
    constraint UKob8kqyqqgmefl0aco34akdtpe
        unique (email),
    constraint FKrc15tfmw1v8xl1u659ypf9418
        foreign key (departement_id) references departement (id)
);

alter table departement
    add constraint FK8ud6r7o4gshtn1vq2034fnpn7
        foreign key (enseignant_id) references user (id);

create table notification
(
    id        bigint auto_increment
        primary key,
    content   varchar(255) null,
    is_readed bit          not null,
    user_id   bigint       not null,
    constraint FKb0yvoep4h4k92ipon31wmdf7e
        foreign key (user_id) references user (id)
);

create table ressource_materielle
(
    dtype              varchar(31)  not null,
    id                 bigint auto_increment
        primary key,
    bar_code           int          not null,
    status             tinyint      null,
    resolution         int          null,
    vitesse_impression double       null,
    cpu                varchar(255) null,
    disk               varchar(255) null,
    ecran              varchar(255) null,
    ram                varchar(255) null,
    appel_offre_id     bigint       null,
    departement_id     bigint       null,
    enseigant_id       bigint       null,
    marque             varchar(255) null,
    date_fin_garantie  datetime(6)  null,
    constraint FK1boffx4kmj6qff4fnutkn6tvd
        foreign key (appel_offre_id) references appel_offre (id),
    constraint FKcbck9tcntb6fc3q9h09qfgl90
        foreign key (departement_id) references departement (id),
    constraint FKcg029n33dlu3kb2d1b1hf49qp
        foreign key (enseigant_id) references user (id)
);

create table panne
(
    id               bigint auto_increment
        primary key,
    date_apparition  datetime(6)  null,
    demander_changer bit          not null,
    demander_reparer bit          not null,
    explication      varchar(255) null,
    frequence        tinyint      null,
    ordre            tinyint      null,
    ressource_id     bigint       not null,
    technicien_id    bigint       not null,
    pane_order       tinyint      null,
    panne_frequence  tinyint      null,
    constraint FK5wawsvsjs4ovpu8evl0rutc6y
        foreign key (technicien_id) references user (id),
    constraint FKobsa6a69hbw9uq82w3r3f1uok
        foreign key (ressource_id) references ressource_materielle (id)
);

create table soumission
(
    id             bigint auto_increment
        primary key,
    date_livraison datetime(6)  null,
    marque         varchar(255) null,
    prix           double       not null,
    fournisseur_id bigint       not null,
    ressource_id   bigint       not null,
    date_garantie  datetime(6)  null,
    constraint FK1oy0ejnay4gxf5lg0eq68ji3q
        foreign key (ressource_id) references ressource_materielle (id),
    constraint FKrj3d022p313j789u1avyk2dnl
        foreign key (fournisseur_id) references user (id)
);

