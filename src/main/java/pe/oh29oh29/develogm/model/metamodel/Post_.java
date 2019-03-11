package pe.oh29oh29.develogm.model.metamodel;

import pe.oh29oh29.develogm.model.Category;
import pe.oh29oh29.develogm.model.Member;
import pe.oh29oh29.develogm.model.Post;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Post.class)
public abstract class Post_ {

    public static volatile SingularAttribute<Post, String> id;
    public static volatile SetAttribute<Post, Category> category;
    public static volatile SetAttribute<Post, Member> member;
    public static volatile SingularAttribute<Post, String> title;
    public static volatile SingularAttribute<Post, String> description;
    public static volatile SingularAttribute<Post, String> contents;
    public static volatile SingularAttribute<Post, String> regDate;
    public static volatile SingularAttribute<Post, String> lastUpdateDate;
    public static volatile SingularAttribute<Post, Integer> views;
    public static volatile SingularAttribute<Post, Boolean> isPrivate;
    public static volatile SingularAttribute<Post, String> urlPathName;

}
