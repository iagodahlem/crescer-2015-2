public void delete(id) {
	em.remove(em.getReference(Cliente.class, id));
}